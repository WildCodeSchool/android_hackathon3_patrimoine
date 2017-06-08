package patrimoine.wcs.fr.toulousemonuments;

/**
 * Created by apprenti on 08/06/17.
 */

public class CommentAdapter {
    private String mComment;

    private  CommentAdapter(){

    }
    public CommentAdapter (String comment){
        this.mComment=comment;
    }

    public String getmComment() {
        return mComment;
    }
}
