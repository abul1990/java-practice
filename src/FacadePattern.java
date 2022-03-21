public class FacadePattern {
    public static void main(String[] args) {
        String test = "test facade pattern";

        FacadeHelper.generateReports("chrome", "html", test);
        FacadeHelper.generateReports("chrome", "unit", test);
        FacadeHelper.generateReports("firefox", "html", test);
        FacadeHelper.generateReports("firefox", "unit", test);
    }
}

class Firefox {
    public static String getDriver() {
        return "Firefox";
    }

    public static void getHtmlReport(String test, String driver) {
        System.out.println("Html " + driver + ", " + test);
    }

    public static void getUnitReport(String test, String driver) {
        System.out.println("Unit " + driver + ", " + test);
    }
}

class Chrome {
    public static String getDriver() {
        return "Chrome";
    }

    public static void getHtmlReport(String test, String driver) {
        System.out.println("Html " + driver + ", " + test);
    }

    public static void getUnitReport(String test, String driver) {
        System.out.println("Unit " + driver + ", " + test);
    }
}

class FacadeHelper {
    public static void generateReports(String explorer, String report, String test) {
        String driver = null;
        switch (explorer) {
            case "firefox":
                driver = Firefox.getDriver();
                switch (report) {
                    case "html":
                        Firefox.getHtmlReport(test, driver);
                        break;
                    case "unit":
                        Firefox.getUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getDriver();
                switch (report) {
                    case "html":
                        Chrome.getHtmlReport(test, driver);
                        break;
                    case "unit":
                        Chrome.getUnitReport(test, driver);
                        break;
                }
                break;
        }
    }
}