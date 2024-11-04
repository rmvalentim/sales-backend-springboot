package br.com.rafaelvalentim.Sales.services;

import br.com.rafaelvalentim.Sales.dtos.OrderCreateDto;
import br.com.rafaelvalentim.Sales.entities.Customer;
import br.com.rafaelvalentim.Sales.entities.Item;
import br.com.rafaelvalentim.Sales.entities.Order;
import br.com.rafaelvalentim.Sales.entities.OrderLine;
import br.com.rafaelvalentim.Sales.repositories.OrderLineRepository;
import br.com.rafaelvalentim.Sales.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CustomerService customerService;
    private final ItemService itemService;
    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;

    public OrderService(CustomerService customerService, ItemService itemService, OrderRepository orderRepository, OrderLineRepository orderLineRepository) {
        this.customerService = customerService;
        this.itemService = itemService;
        this.orderRepository = orderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    public Order createOrder(OrderCreateDto orderCreateDto) {
        Customer customer = customerService.getCustomerById(orderCreateDto.getCustomerId());
        Order order = new Order();
        order.setDate(orderCreateDto.getDate())
                        .setCustomer(customer);
        Order savedOrder = orderRepository.save(order);

        orderCreateDto.getOrderLines().forEach((orderLineDto) -> {
            Item item = itemService.getItemById(orderLineDto.getItemId());
            OrderLine orderLine = new OrderLine();
            orderLine.setOrder(savedOrder)
                    .setItem(item)
                    .setDescription(item.getDescription())
                    .setPrice(orderLineDto.getPrice());
            orderLineRepository.save(orderLine);
        });
        return order;
    }

    public Order getOrderById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }
}
