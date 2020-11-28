package aks.fatdevs.noteit.DataAndModels;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class Model {
    private String note_title;
    private String image_uri;
    private StringBuffer note_para;
    private String time;
    public Model( @NonNull String note_title,@Nullable StringBuffer note_para, @NonNull String time,  @Nullable String image_uri) {

        this.note_title = note_title;
        this.image_uri = image_uri;
        this.note_para = note_para;
        this.time = time;
    }
    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

    public String getNote_para() {
        return note_para.toString();
    }

    public void setNote_para(StringBuffer note_para) {
        this.note_para = note_para;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
