package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants{
        public final static String SERVER_NOT_ACCESSIBLE_EXCEPTIION = "Server is not accessible for now.";
        public final static String UNAUTHORIZED_USER_EXCEPTIION = "User is not authorized.";
        public final static String BANNED_USER_EXCEPTIION = "User is banned.";
        public final static String RESTRICTION_EXCEPTIION = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SERVER_NOT_ACCESSIBLE_EXCEPTIION);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SERVER_NOT_ACCESSIBLE_EXCEPTIION, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UNAUTHORIZED_USER_EXCEPTIION);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UNAUTHORIZED_USER_EXCEPTIION, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BANNED_USER_EXCEPTIION);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BANNED_USER_EXCEPTIION, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RESTRICTION_EXCEPTIION);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RESTRICTION_EXCEPTIION, cause);
        }
    }
}
