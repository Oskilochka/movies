import React from "react";
import { useParams } from "react-router-dom";
import ReactPlayer from "react-player";

import styles from './style.module.scss'

export const Trailer = React.memo(() => {
    const { ytTrailerId } = useParams();

    return (
        <div className={styles.wrap}>
            {
                ytTrailerId &&
                <ReactPlayer
                    controls={true}
                    width={"100%"}
                    height={"100%"}
                    url={`https://www.youtube.com/watch?v=${ytTrailerId}`}
                />
            }
        </div>
    );
});
