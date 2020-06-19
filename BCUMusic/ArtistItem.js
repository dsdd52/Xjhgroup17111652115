import React, {Component} from 'react';
import {TouchableOpacity,Image,Text} from 'react-native';

export default class ArtistItem extends Component {
    constructor(props) {
        super(props)
    }
    render() {
        return (
            <TouchableOpacity style={{marginBottom:20,backgroundColor:'#cccccc77',borderRadius:5,padding:8}}>
                <Image source={{uri:this.props.collection.artistImg}} style={{width:90,height:90}}/>
                <Text style={{fontSize:15,textAlign: 'center',marginTop:5}}>{this.props.collection.artistName}</Text>
            </TouchableOpacity>
        )
    }
}
