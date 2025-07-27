import React , {Component} from 'react';

class CountPeople extends Component{
    constructor(props){
        super(props);
        this.state={
            entrycount:0,
            exitcount:0,
        };
    }

    updateEntry = () =>{
        this.setState((prevState)=>({
            entrycount : prevState.entrycount + 1,
        }));
    }

     updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1,
    }));
  };

  render() {
    return (
      <div style={{ marginTop: '100px', textAlign: 'center' }}>
        <button onClick={this.updateEntry} style={{ backgroundColor: 'lightgreen', marginRight: '25px' }}>Login</button>
        <span style={{ marginRight: '50px', fontSize: '1.2em' }}>
          {this.state.entrycount} People Entered!!!
        </span>

        <button onClick={this.updateExit} style={{ backgroundColor: 'lightgreen', marginRight: '20px' }}>Exit</button>
        <span style={{ fontSize: '1.2em' }}>
          {this.state.exitcount} People Left!!!
        </span>
      </div>
    );
  }
}

export default CountPeople;