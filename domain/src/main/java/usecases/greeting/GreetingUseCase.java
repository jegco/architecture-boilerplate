package usecases.greeting;

import io.reactivex.Completable;
import org.springframework.stereotype.Service;
import usecases.base.CompletableUseCase;

@Service
public class GreetingUseCase<Object> extends CompletableUseCase<Object> {

    @Override
    protected Completable buildUseCase(Object params) {
        return Completable.create(emitter -> {
            System.out.println("hello from completable use case");
            emitter.onComplete();
        });
    }
}
