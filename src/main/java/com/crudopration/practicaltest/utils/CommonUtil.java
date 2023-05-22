package com.crudopration.practicaltest.utils;

import com.crudopration.practicaltest.common.constant.Constants;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
    
        public static List<String> userStatus() {
        List<String> userStatus = new ArrayList<>();
        userStatus.add(Constants.ACTIVE);
//        userStatus.add(Constants.DELETED);
        return userStatus;
    }


    public static List<String> userDetailsStatus() {
        List<String> userDetailsStatus = new ArrayList<>();
        userDetailsStatus.add(Constants.ACTIVE);
//        userDetailsStatus.add(Constants.DELETED);
        return userDetailsStatus;
    }
    
}
