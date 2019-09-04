package com.yeamy.ncmdump;

/**
 * file id3 info for dump
 * 
 * @author Yeamy0754
 */
public class ID3Data {
//	"musicId":39224884,
//	"musicName":"Cheap Thrills",
//	"artist":[["Sia",74625]],
//	"albumId":3394107,
//	"album":"This Is Acting",
//	"albumPicDocId":"18176026719076230",
//	"albumPic":"http://p3.music.126.net/fDUMN_6ITc4gvoDko06uKw==/18176026719076230.jpg",
//	"bitrate":320000,
//	"mp3DocId":"53a6c94faab6926386c571d484859bd2",
//	"duration":211666,
//	"mvId":5304134,
//	"alias":[],
//	"transNames":[],
//	"format":"mp3"

	public String album;
	public String musicName;
	public String[][] artist;
	public String format;

	public boolean isMP3() {
		return "mp3".equals(format);
	}

	public String artist() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < artist.length; i++) {
			if (sb.length() > 0) {
				sb.append(", ");
			}
			sb.append(artist[i][0]);
		}
		return sb.toString();
	}

}
