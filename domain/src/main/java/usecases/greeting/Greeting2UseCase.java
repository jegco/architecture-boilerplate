package usecases.greeting;

import io.reactivex.Observable;
import model.Greeting;
import org.springframework.stereotype.Service;
import usecases.base.ObservableUseCase;

@Service
public class Greeting2UseCase extends ObservableUseCase<Greeting, Object> {

    @Override
    protected Observable<Greeting> buildUseCase(Object params) {
        return Observable.just(new Greeting(1, "hi, im a greeting from use case :)"));
    }
}
