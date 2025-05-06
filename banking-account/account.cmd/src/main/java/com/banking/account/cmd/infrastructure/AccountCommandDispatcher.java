import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AccountCommandHandlerDispatcher implements CommandHandlerDispatcher {
    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod handler) {
        List<CommandHandlerMethod> handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public void send(BaseCommand command) {
        var handlers = routes.get(command.getClass());
        if (handlers == null || handlers.size() == 0) {
            throw new RuntimeException("Command handler was not registered!");
        }
        if (handlers.size() > 1) {
            throw new IllegalStateException("Cannot send a command that has more than one handler!");
        }
        handlers.get(0).handle(command);
    }
}