package repositories;

import mappers.GreetingDataGreetingMapper;
import model.Greeting;
import model.GreetingData;
import org.springframework.stereotype.Component;

@Component
public class GreetingRepository implements IGreetingRepository {

    @Override
    public Greeting getGreeting() {
        return GreetingDataGreetingMapper.
                getInstance().
                apply(new GreetingData(1, "hi, im a greeting from repository"));
    }
}
