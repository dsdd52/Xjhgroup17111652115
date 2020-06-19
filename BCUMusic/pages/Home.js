import {View} from 'react-native';
import React, {Component} from 'react';
export default class Home extends Component {
    constructor(props) {
        super(props);
    }

    componentDidMount() {
    }

    render() {
        return (
            <View style={{flex: 1, backgroundColor: "blue"}}></View>
        )
    }
}
