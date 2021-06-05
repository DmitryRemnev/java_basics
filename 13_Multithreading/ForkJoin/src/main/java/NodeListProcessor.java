import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class NodeListProcessor extends RecursiveTask<List<String>> {

    private final Node node;

    public NodeListProcessor(Node node) {
        this.node = node;
    }

    @Override
    protected List<String> compute() {

        List<String> weatherList = new ArrayList<>();

        List<NodeListProcessor> taskList = new ArrayList<>();

        for (Node child : node.getChildren()) {
            NodeListProcessor task = new NodeListProcessor(child);
            task.fork();
            taskList.add(task);
        }

        for (NodeListProcessor task : taskList) {
            weatherList.add(task.toString());
        }

        addResultsFromTasks(weatherList, taskList);

        return weatherList;
    }

    private void addResultsFromTasks(List<String> list, List<NodeListProcessor> tasks) {
        for (NodeListProcessor item : tasks) {
            list.addAll(item.join());
        }
    }
}