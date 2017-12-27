package dev.exercise.Dependency;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;



class Tree {

    private Node rootNode;
    private LinkedHashMap dependencyNodes = new LinkedHashMap();

    public void loadFileContents(Path file) {


        // loop through each line in file
        try (InputStream in = Files.newInputStream(file);

             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;

            while ((line = reader.readLine()) != null) {
                parseLineIntoNodes(line, "->");
            }

            // add to rootNode
            dependencyNodes.forEach((key,value) -> {
                Node node = (Node) value;
                if (node.root) {
                    rootNode = node;
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLineIntoNodes(String line, String delim){
        String output[] = line.split(delim);
        String a = output[0];
        String b = output[1];

        Node nodeA = findOrCreateNode(dependencyNodes, a);
        Node nodeB = findOrCreateNode(dependencyNodes, b);

        nodeB.root = false;

        nodeA.children.add(nodeB);
    }


    private static Node findOrCreateNode(Map<String, Node> nodes, String name) {
        if (nodes.get(name) == null) {
            return addNode(nodes, name);
        } else {
            return nodes.get(name);
        }
    }


    private static Node addNode(Map<String, Node> nodes, String name) {
        Node node = new Node(name);
        nodes.put(name, node);
        return node;
    }


    public void render(BufferedWriter bufferedWriter) {
        rootNode.writeNode(bufferedWriter);
    }
}
