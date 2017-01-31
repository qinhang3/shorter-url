import React from 'react';
import whiteImg from '../../../image/gobang/white.jpg';
import blackImg from '../../../image/gobang/black.jpg';

class Chess extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            visibility : "hidden"
        };
    }
    render() {
        return <div style={{top : this.props.top, left : this.props.left,position: "absolute"}} onClick={this.click.bind(this)}>
            <img src={this.getImage(this.props.type)} style={{width : this.props.width, visibility : this.state.visibility}}/>
        </div>
    }

    getImage(type){
        if (type == 'white'){
            return whiteImg
        }
        if (type == 'black'){
            return blackImg
        }
    }

    click(){
        console.log(this.props.top);
        console.log(this.props.left);
        this.setState({visibility : "visible"})
    }
}
export default Chess