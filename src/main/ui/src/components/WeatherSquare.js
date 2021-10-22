import React from 'react'

export const WeatherSquare = ({getWeather}) => {
    return(
        <div className="wSquare">
            <h1>Gangs of London</h1>
             <div className="btn">
                <button type="button" onClick={() => getWeather()} className="btn btn-warning">Get Weather</button>
             </div>
        </div>

    )

}
