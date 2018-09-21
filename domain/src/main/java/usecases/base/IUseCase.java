package usecases.base;

import io.reactivex.disposables.Disposable;

import java.util.function.Consumer;

public interface IUseCase<R, P> {

    Disposable execute(P params, Consumer<R> onSuccessSubscriber, Consumer<Throwable> onErrorSubscriber);
}
