package controllers;

import io.reactivex.disposables.CompositeDisposable;
import model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import usecases.base.ICompletableUseCase;
import usecases.base.IUseCase;


@RestController
public class GreetingController {

    @Autowired
    private ICompletableUseCase mGreetingUseCase;

    @Autowired
    private
    IUseCase<Greeting, Object> mGreetinh2UseCase;

    private CompositeDisposable mSubscriptions = new CompositeDisposable();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        final Greeting[] response = {null};
        mSubscriptions.add(mGreetinh2UseCase.execute(null,
                greeting -> {
                    System.out.println(greeting.getContent());
                    response[0] = greeting;
                },
                throwable -> System.out.println(throwable.getMessage())));
        return response[0];
    }

    @RequestMapping("/greeting2/completable")
    public void greetingFromCompletable() {
        mSubscriptions.add(mGreetingUseCase.execute(null, o -> print("hello from controller"), throwable -> print(throwable.toString())));
    }

    private void print(String message) {
        System.out.print(message);
    }
}