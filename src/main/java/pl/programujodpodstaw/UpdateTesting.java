package pl.programujodpodstaw;

public class UpdateTesting {
    boolean isOk;
    int numberOfUpdates;
    String updateName;
    String errorCode;

    public String testUpdate (boolean isOk){
        if (isOk){
            return updateName;
        }else{
            return errorCode;
        }
    }
}
