package usecases.greeting;

import io.reactivex.Observable;
import model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IGreetingRepository;
import usecases.base.ObservableUseCase;

@Service
public class Greeting2UseCase extends ObservableUseCase<Greeting, Object> {

    @Autowired
    public IGreetingRepository greetingRepository;

    @Autowired
    public Greeting2UseCase(IGreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    protected Observable<Greeting> buildUseCase(Object params) {
        return Observable.just(greetingRepository.getGreeting());
    }
}
