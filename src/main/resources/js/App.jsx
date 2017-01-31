import React from 'react';
import Gobang from './game/Gobang.jsx';

class App extends React.Component {
    render() {
        if (this.state.type == "gobang"){
            return <Gobang/>
        } else {
            return <div>
                <button onClick={this.chagneType.bind(this,"gobang")}>GOBANG 五子棋</button>
            </div>
        }
    }

    chagneType(type){
        this.setState({
            type
        })
    }

    constructor(props) {
        super(props)
        this.state = {
            type : "gobang"
        };
    }
}
export default App;