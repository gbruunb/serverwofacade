package serverwofacade;

/**
 *
 * @author 65050521
 */
public class ServerFacade {
    private static ServerFacade myFacadeObj = null;

    private ServerFacade() {
    }

    public static ServerFacade getFacade() {
        if (myFacadeObj == null) {
            myFacadeObj = new ServerFacade();
        }
        return myFacadeObj;
    }

    public void startServer(ScheduleServer scheduleServer) {
        if (scheduleServer == null) {
            System.out.println("Please provide server to start");
            return;
        }
        scheduleServer.startBooting();
        scheduleServer.readSystemConfigFile();
        scheduleServer.init();
        scheduleServer.initializeContext();
        scheduleServer.initializeListeners();
        scheduleServer.createSystemObjects();
        System.out.println("Start working......");
    }

    public void closeServer(ScheduleServer scheduleServer) {
        if (scheduleServer == null) {
            System.out.println("Don't have server to close");
            return;
        }
        System.out.println("After work done.........");
        scheduleServer.releaseProcesses();
        scheduleServer.destory();
        scheduleServer.destroySystemObjects();
        scheduleServer.destoryListeners();
        scheduleServer.destoryContext();
        scheduleServer.shutdown();
    }
}
