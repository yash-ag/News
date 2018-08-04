package com.example.android.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by agarw on 24-07-2018.
 */

public class ArticleAdapter extends ArrayAdapter {

    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Article currentArticle = (Article) getItem(position);

        TextView sectionView = (TextView) listItemView.findViewById(R.id.source);
        sectionView.setText(currentArticle.getSource());

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentArticle.getTitle());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date dateObject = null;
        try {
            dateObject = sdf.parse(currentArticle.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = formatDate(dateObject);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formatDate(dateObject));

        return listItemView;
    }

    public String formatDate(Date d) {
        SimpleDateFormat timeFormat = new SimpleDateFormat(" MMM d, h:mm a");
        return timeFormat.format(d);
    }
}
