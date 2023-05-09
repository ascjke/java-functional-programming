class Tutorial {
private String name;

    // constructors, getters and setters
}

interface Client {

    List<Tutorial> getTutorials();
}

public void printTutorialsCount() {

    List<Tutorial> tutorials = client.getTutorials();
    logger.info("Number of tutorials: " + tutorials.size());
}

Non async
![img.png](img.png)


Asynchronous approach
![img_1.png](img_1.png)


get()
![img_2.png](img_2.png)

thenAccept()
![img_3.png](img_3.png)
