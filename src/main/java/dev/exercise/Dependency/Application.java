package dev.exercise.Dependency;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;


class Application {

    public static void main(String args[]) {

        Tree dependencyTree = new Tree();

        if (args == null || args.length == 0) {
            System.out.println("ERROR: Please include a file name with full path as argument.");
            System.exit(1);
        }

        System.out.printf("Reading file \"%s\"...\n", args[0]);

        dependencyTree.loadFileContents(Paths.get(args[0]));

        dependencyTree.render(new BufferedWriter(new OutputStreamWriter(System.out)));

    }

}
