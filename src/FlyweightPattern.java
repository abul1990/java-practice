import java.util.HashMap;

public class FlyweightPattern {

    public static void main(String[] args) {
        Resource resource = ResourceFactory.getResource("Developer");
        resource.assignTask("Java");
        resource.task();
    }

}

interface Resource {
    void assignTask(String skill);

    void task();
}

class Developer implements Resource {
    private final String job;
    private String skill;

    public Developer() {
        job = "Fix the issue";
    }

    @Override
    public void assignTask(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer: " + this.skill + " Job: " + job);

    }
}

class Tester implements Resource {
    private final String job;
    private String skill;

    public Tester() {
        job = "Find issue";
    }

    @Override
    public void assignTask(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester: " + this.skill + " Job: " + job);

    }
}

class ResourceFactory {
    private static HashMap<String, Resource> map = new HashMap<>();

    public static Resource getResource(String type) {
        Resource resource = null;
        if (map.get(type) != null) {
            resource = map.get(type);
        } else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    resource = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    resource = new Tester();
                    break;
            }
            map.put(type, resource);
        }
        return resource;
    }
}
