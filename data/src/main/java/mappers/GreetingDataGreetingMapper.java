package mappers;

import model.Greeting;
import model.GreetingData;

import java.util.function.Function;

public class GreetingDataGreetingMapper implements Function<GreetingData, Greeting> {

    private static GreetingDataGreetingMapper instance;

    private GreetingDataGreetingMapper() {
    }

    public static GreetingDataGreetingMapper getInstance() {
        if (instance == null) {
            instance = new GreetingDataGreetingMapper();
        }
        return instance;
    }

    @Override
    public Greeting apply(GreetingData greetingData) {
        return new Greeting(greetingData.getId(), greetingData.getContent());
    }
}
