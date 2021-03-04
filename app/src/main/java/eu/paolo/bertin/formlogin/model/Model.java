package eu.paolo.bertin.formlogin.model;

public class Model {

    public String verifyLogin(String username, String password) {

        boolean valid = true;
        StringBuilder message = new StringBuilder();
        if (username.isEmpty()) {
            valid = false;
            message.append("La lunghezza di username de essere > 0\n");
        }

        if (password.length() < 7) {
            valid = false;
            message.append("La password deve avere lunghezza >= 7\n");
            message.append("La password deve contenere almeno un numero\n");
            message.append("La password deve contenere almeno un carattere maiuscolo\n");
            message.append("La password deve contenere al meno uno dei caratteri !,?,@ o #");
            return message.toString();
        }

        String[] array = password.split("");
        // verifica la presenza di un numero, di un carattere maiuscolo
        boolean numberFlag = false;
        boolean capitalFlag = false;
        boolean specialFlag = false;
        for (String c : array) {

            if (Character.isDigit(c.charAt(0))) {
                numberFlag = true;
            }
            if (Character.isUpperCase(c.charAt(0))) {
                capitalFlag = true;
            }
            if (c.charAt(0) == '!' || c.charAt(0) == '?' || c.charAt(0) == '@' || c.charAt(0) == '#') {
                specialFlag = true;
            }
        }

        if (!numberFlag) {
            valid = false;
            message.append("La password deve contenere almeno un numero\n");
        }
        if (!capitalFlag) {
            valid= false;
            message.append("La password deve contenere almeno un carattere maiuscolo\n");
        }
        if(!specialFlag){
            valid= false;
            message.append("La password deve contenere al meno uno dei caratteri !,?,@ o #");
        }
        if(valid) {
            message.append("credenziali valide");
        }

        return message.toString();
    }


}
