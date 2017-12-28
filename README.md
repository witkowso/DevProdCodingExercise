# Dependency Hierarchy View Exercise

## INSTRUCTIONS:
__Problem:__ Given a dependency graph, print a hierarchical view of the dependencies.

__Data:__ The graph is in the attached graph.txt file. The data is provided in the form "X->Y", stating that X depends on Y.

__Assignment:__ Walk the dependency graph, starting at A, printing out each dependency. Repeat for each dependency visited, indenting along the way. E.g.  If A depends on B and C, and B depends on C and D, and D depends on E the output should look like this:

    A
    |_ B
    |  |_ C
    |  \_ D
    |     \_ E
    \_ C

__Deliverable:__ Implement in any JVM-based language of your choice. Consider how we might run your solution. If you normally develop with automated tests, please include them; otherwise please include a short list of manual tests.

__Level of Effort:__ In terms of level of effort and prioritization around code elegance, polish, and productized thoughtfulness, we expect this will take no more than about four hours, depending on how much work you want to put into it.  Think of this as "I need to put something up that my users will actually be using on a daily basis, but I don't have days and days to work on it" as a general way to think about your final product. We don't expect you to give us something back within a day – we know, and appreciate, the fact you've got a busy life and a job.  


## Usage

You can use Gradle to run this application using the default text file.

    ./gradlew -Pfile=/path/to/project/src/main/resources/graph.txt run

The dependency tree will be generated as follows:

    A
    |_ B
    |  |_ C
    |  |  |_ E
    |  |     |_ H
    |  |     |  |_ L
    |  |     |     |_ I
    |  |     |        |_ O
    |  |     |        |  |_ P
    |  |     |        |     |_ Q
    |  |     |        |_ P
    |  |     |        |  |_ Q
    |  |     |        |_ K
    |  |     |           |_ N
    |  |     |           |_ L ...
    |  |     |_ M
    |  |        |_ N
    |  |        |_ H
    |  |           |_ L
    |  |              |_ I
    |  |                 |_ O
    |  |                 |  |_ P
    |  |                 |     |_ Q
    |  |                 |_ P
    |  |                 |  |_ Q
    |  |                 |_ K
    |  |                    |_ N
    |  |                    |_ L ...
    |  |_ D
    |     |_ F
    |     |  |_ H
    |     |     |_ L
    |     |        |_ I
    |     |           |_ O
    |     |           |  |_ P
    |     |           |     |_ Q
    |     |           |_ P
    |     |           |  |_ Q
    |     |           |_ K
    |     |              |_ N
    |     |              |_ L ...
    |     |_ G
    |     |_ J
    |        |_ I
    |        |  |_ O
    |        |  |  |_ P
    |        |  |     |_ Q
    |        |  |_ P
    |        |  |  |_ Q
    |        |  |_ K
    |        |     |_ N
    |        |     |_ L
    |        |        |_ I ...
    |        |_ Q
    |_ J
       |_ I
       |  |_ O
       |  |  |_ P
       |  |     |_ Q
       |  |_ P
       |  |  |_ Q
       |  |_ K
       |     |_ N
       |     |_ L
       |        |_ I ...
       |_ Q

## Log

* 3:00pm - Review instructions/email, research aka Google what others have done, existing tools, etc
* 3:19pm - Create Java project in IntelliJ
* 4:15pm - Program reads file, loadFileContents() is completed
* 10 min break, walk around, get drink
* 4:40pm - render() works
* 5:20pm - tried differentiating between | and \ depending on order of dependency name, not successful so added placeholder in Node.java line 30
* 5:25pm - create Readme, update with info
* 5:50pm - initial commit
* Dinner until about 8pm
* 9:10pm - add comments, update readme, clean up code, add test skeleton
