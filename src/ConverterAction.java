import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by el1ven on 14-5-16.
 */
public class ConverterAction extends ActionSupport {
    private Person person;
    public String execute(){
        return SUCCESS;
    }
    public Person getPerson(){
        return person;
    }
    public void setPerson(Person person){
        this.person = person;
    }
}
