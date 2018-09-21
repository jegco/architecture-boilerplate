package usecases.base;

import io.reactivex.disposables.Disposable;

import java.util.function.Consumer;

public interface ICompletableUseCase<P> {

    Disposable execute(P params,
                       Consumer<Void> onSuccessfulSubscriber,
                       Consumer<Throwable> onErrorSubscriber);
}
