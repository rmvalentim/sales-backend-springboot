package br.com.rafaelvalentim.Sales.services;

import br.com.rafaelvalentim.Sales.dtos.LoginUserDto;
import br.com.rafaelvalentim.Sales.dtos.RegisterUserDto;
import br.com.rafaelvalentim.Sales.entities.Role;
import br.com.rafaelvalentim.Sales.entities.RoleEnum;
import br.com.rafaelvalentim.Sales.entities.User;
import br.com.rafaelvalentim.Sales.repositories.RoleRepository;
import br.com.rafaelvalentim.Sales.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
    }

    public User signup(RegisterUserDto input) {

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if(optionalRole.isEmpty()) {
            return null;
        }

        User user = new User()
                .setName(input.getName())
                .setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setRole(optionalRole.get());

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}