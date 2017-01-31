import React from 'react';
import Chess from './common/chess.jsx';
import bkg from '../../image/gobang/background.png';
import '../../css/gobang.css';

class Gobang extends React.Component {
    constructor(props) {
        super(props)
    }
    render() {
        var width = 600;
        return <div style={{position: "absolute"}}>
            <img src={bkg} width={width}/>
            {this.getChess(`${width/20}px`,"white")}
            {/*{this.getChess(`${width/20}px`,"black")}*/}
        </div>
    }

    getChess(width,type){
        var data = [];
        var top = [];
        var left = [];

        var start = 6;
        var end = 89;
        var c= (end-start)/16;
        for (var i =0;i<17;i++){
            left.push(start + i * c);
            top.push(start + i * c);
        }

        for (var i = 0;i < top.length; i++){
            for (var j = 0; j < left.length; j++) {
                data.push(<Chess width={width} top={`${top[i]}%`} left={`${left[j]}%`} type={type}/>)
            }
        }

        return data;
    }
}
export default Gobang