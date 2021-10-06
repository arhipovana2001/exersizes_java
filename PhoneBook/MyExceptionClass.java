class PhoneNumberAlreadyExists extends Exception{

    public PhoneNumberAlreadyExists(){

    }

    public PhoneNumberAlreadyExists(String message){
        super(message);
    }
}

class RecordNotFound extends Error{

    public RecordNotFound(){
        super();
    }
    public RecordNotFound(String message){
        super(message);

    }
}

class RecordNotValid extends Exception{
    public RecordNotValid(){

    }
    public RecordNotValid(String message){
        super(message);

    }
}


