public class ProxyPattern {
    public static void main(String[] args) {
        DatabaseExecutorProxy proxy = new DatabaseExecutorProxy();
        proxy.execute("select");
        proxy.execute("delete");
    }
}

interface DatabaseExecutor {
    void execute(String q);
}

class DatabaseExecutorImpl implements DatabaseExecutor {

    @Override
    public void execute(String q) {
        System.out.println("executed: " + q);
    }
}

class DatabaseExecutorProxy implements DatabaseExecutor {
    @Override
    public void execute(String q) {
        if (q.contains("delete")) {
            throw new RuntimeException("Delete not allowed");
        }
        DatabaseExecutorImpl databaseExecutor = new DatabaseExecutorImpl();
        databaseExecutor.execute(q);
    }
}
