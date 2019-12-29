package com.example.android.sunshine;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>
{
    private String[] mWeatherData;

    public ForecastAdapter()
    {

    }

    public void setWeatherData(String[] weatherData)
    {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder
    {
        public final TextView mWeatherDataTextView;

        public ForecastAdapterViewHolder(View view)
        {
            super(view);
            mWeatherDataTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }

    @NonNull
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position)
    {
        Context context = viewGroup.getContext();
        int layoutId = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean isAttachedToParentDirectly = false;

        View view = inflater.inflate(layoutId, viewGroup, isAttachedToParentDirectly);

        return new ForecastAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastAdapterViewHolder forecastAdapterViewHolder, int position)
    {
        String weatherForThisDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherDataTextView.setText(weatherForThisDay);
    }

    @Override
    public int getItemCount()
    {
        if (mWeatherData == null)
            return 0;
        return mWeatherData.length;
    }
}
