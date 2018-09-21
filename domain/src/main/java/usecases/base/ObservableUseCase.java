package usecases.base;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public abstract class ObservableUseCase<R, P> implements IUseCase<R, P> {

    protected abstract Observable<R> buildUseCase(P params);

    @Override
    public Disposable execute(P params, Consumer<R> onSuccessSubscriber, Consumer<Throwable> onErrorSubscriber) {
        return buildUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(onSuccessSubscriber::accept,
                        onErrorSubscriber::accept);
    }
}
