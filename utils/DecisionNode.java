package utils;

public interface DecisionNode {
    public enum Status{NE, E, SE, S, SW, W, NW , N}
    Status execute();
}
