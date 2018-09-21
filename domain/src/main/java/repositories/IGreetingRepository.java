package repositories;

import model.Greeting;
import org.springframework.stereotype.Component;

@Component
public interface IGreetingRepository {
    Greeting getGreeting();
}
