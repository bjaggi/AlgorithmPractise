package design.elevator;

public interface RulesManager {
    void enqueue(Request request);
    int getNextDestination();
}
