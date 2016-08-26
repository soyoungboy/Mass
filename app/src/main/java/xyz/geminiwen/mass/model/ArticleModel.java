package xyz.geminiwen.mass.model;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

/**
 * Created by geminiwen on 16/8/25.
 */
public class ArticleModel extends BaseModel {

    private long id;
    private String url;
    private String title;
    private String createdDate;
    private String excerpt;
    private String originalText;
    private String parsedText;
    private String currentStatus;
    private int votes;
    private int bookmarks;
    private int comments;
    @SerializedName("isLiked")
    private boolean liked;
    @SerializedName("isHated")
    private boolean hated;
    @SerializedName("isBookmarked")
    private boolean bookmarked;
    @SerializedName("isOffline")
    private boolean offline;


    public ArticleModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.createdDate);
        dest.writeString(this.excerpt);
        dest.writeString(this.originalText);
        dest.writeString(this.parsedText);
        dest.writeString(this.currentStatus);
        dest.writeInt(this.votes);
        dest.writeInt(this.bookmarks);
        dest.writeInt(this.comments);
        dest.writeByte(this.liked ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hated ? (byte) 1 : (byte) 0);
        dest.writeByte(this.bookmarked ? (byte) 1 : (byte) 0);
        dest.writeByte(this.offline ? (byte) 1 : (byte) 0);
    }

    protected ArticleModel(Parcel in) {
        this.id = in.readLong();
        this.url = in.readString();
        this.title = in.readString();
        this.createdDate = in.readString();
        this.excerpt = in.readString();
        this.originalText = in.readString();
        this.parsedText = in.readString();
        this.currentStatus = in.readString();
        this.votes = in.readInt();
        this.bookmarks = in.readInt();
        this.comments = in.readInt();
        this.liked = in.readByte() != 0;
        this.hated = in.readByte() != 0;
        this.bookmarked = in.readByte() != 0;
        this.offline = in.readByte() != 0;
    }

    public static final Creator<ArticleModel> CREATOR = new Creator<ArticleModel>() {
        @Override
        public ArticleModel createFromParcel(Parcel source) {
            return new ArticleModel(source);
        }

        @Override
        public ArticleModel[] newArray(int size) {
            return new ArticleModel[size];
        }
    };
}
