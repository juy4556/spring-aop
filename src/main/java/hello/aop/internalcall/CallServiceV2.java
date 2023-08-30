package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV2 {

    private final ObjectProvider<CallServiceV2> callServiceProvider;
    public void external() {
        log.info("call external");
        CallServiceV2 callService = callServiceProvider.getObject();
        callService.internal(); //주입받은 자신의 프록시 객체의 internal 메서드 실행
    }
    public void internal() {
        log.info("call internal");
    }
}