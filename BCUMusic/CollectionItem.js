import React, {Component} from 'react';
import {TouchableOpacity,Image,Text} from 'react-native';

export default class Home extends Component {
    constructor(props) {
        super(props)
    }
    _showCollection(item){
        this.props.showCollection(item)
    }

    render() {
        return (
            <TouchableOpacity
                style={{marginBottom:20,backgroundColor:'#cccccc77',borderRadius:5,padding:8}}
                onPress={(data)=>this._showCollection(this.props.collection)}
            >
                <Image source={{uri:this.props.collection.collectionImg}} style={{width:90,height:90}}/>
                <Text style={{fontSize:15,textAlign: 'center',marginTop:5}}>{this.props.collection.collectionName}</Text>
            </TouchableOpacity>
        )
    }
}
