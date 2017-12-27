package dev.exercise.Dependency;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;


class Node {

    private final String name;
    boolean root = true;
    final List<Node> children = new ArrayList<>();


    public Node(String s) {
        name = s;
    }


    void writeNode(BufferedWriter writer) {
        try {
            output(writer, new ArrayList<>(), 0, "", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void output(BufferedWriter writer, List<String> visited, int depth, String prefix, boolean leaf) throws IOException {
        String pipeOrSlash = (0 == 0) ? "|" : "\\"; // TODO: replace with valid condition

        String startString = root ?  name  : prefix + pipeOrSlash + "_ " + name;
        writer.write(startString);

        if (cyclicDependencyCheck(visited, depth)) {
            writer.write (" ...");
            writer.newLine();
            return;
        }

        writer.newLine();

        for (int i = 0; i < children.size(); i ++) {
            Node child = children.get(i);
            String nextPrefix = root ? "" : (prefix + (leaf ? "   " : "|  "));
            child.output(writer, visited, depth + 1, nextPrefix, i == children.size() - 1);
        }

        writer.flush();
    }


    private boolean cyclicDependencyCheck(List<String> visited, int depth) {
        if (visited.size() > depth) {
            LinkedList truncated = new LinkedList(visited.subList(0, depth));
            visited.clear();
            visited.addAll(truncated);
        }

        boolean cycle = visited.contains(name);

        if (!cycle) {
            visited.add(name);
        }

        return cycle;
    }
}
