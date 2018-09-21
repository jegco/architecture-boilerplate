package usecases.base;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.function.Consumer;

public abstract class CompletableUseCase<P> implements ICompletableUseCase<P> {

    protected abstract Completable buildUseCase(P params);

    @Override
    public Disposable execute(P params, Consumer<Void> onSuccessfulSubscriber, Consumer<Throwable> onErrorSubscriber) {
        return buildUseCase(params).
                subscribeOn(Schedulers.io()).
                observeOn(Schedulers.single())
                .subscribe(() -> onSuccessfulSubscriber.accept(null), onErrorSubscriber::accept);
    }
}
