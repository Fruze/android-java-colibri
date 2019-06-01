package win.towert.colibri.common.api;

public abstract class ApiRoute {
    private static final String API_BASE_ROUTE = "https://328b327d-81b8-407d-a3cf-549672276fca.mock.pstmn.io";

    private static final String API_LOGIN = API_BASE_ROUTE + "/login";
    public static String getApiLogin() {
        return API_LOGIN;
    }
}
