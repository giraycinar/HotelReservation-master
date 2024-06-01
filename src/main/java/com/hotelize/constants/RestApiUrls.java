package com.hotelize.constants;

public class RestApiUrls {
    private static final String VERSION = "/v1";
    private static final String API = "/api";
    private static final String TEST = "/test";
    private static final String DEV = "/dev";
    private static final String PROD = "/prod";




    private static final String ROOT = DEV + VERSION;
    public static final String AUTH = ROOT + "/auth";
    public static final String USER = ROOT + "/user";
    public static final String COMMENT = ROOT + "/comment";
    public static final String FEATURES = ROOT + "/features";
    public static final String HOTEL = ROOT + "/hotel";
    public static final String HOTEL_FEATURES = ROOT + "/hotel-features";
    public static final String HOTEL_TAGS = ROOT + "/hotel-tags";
    public static final String HOTEL_TOUR = ROOT + "/hotel-tour";
    public static final String HOTEL_ACTIVITIES = ROOT + "/hotel-activities";
    public static final String HOTELPROMOTION = ROOT + "/hotel-promotion";
    public static final String LOCATION = ROOT + "/location";
    public static final String TAGS = ROOT + "/tags";
    public static final String TOUR = ROOT + "/tour";
    public static final String USERPROFILE = ROOT + "/user-profile";




    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String FIND_ALL = "/find-all";
    public static final String ADD = "/add";
    public static final String GET_ALL = "/get-all";
    public static final String GET_BY_ID = "/get-by-id";
    public static final String DELETE_BY_ID = "/delete-by-id";
    public static final String REGISTER = "/register";
    public static final String LOGIN = "/login";
    public static final String FIND_BY_ID = "/find-by-id";
    public static final String FIND_POPULAR = "/find-popular";
    public static final String DELETE_BY_TOKEN = "/delete-by-token";
    public static final String ACTIVATE_STATUS = "/activate-status";
    public static final String GET_ID_FROM_TOKEN = "/get-id-from-token";
    public static final String GET_FAVOURITES = "/get-favourites";
    public static final String ADD_FAVOURITE = "/add-favourite";
    public static final String GET_FILTERED_HOTELS = "/get-filtered-hotels";

    public static final String HOTEL_FIND_SEARCH = "/hotel-find-search";
    public static final String ACTIVATE_ACCOUNT = "/activate-account";
    public static final String CREATE_TOKEN = "/create-token";



}
