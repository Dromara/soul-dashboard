import React, { Component } from "react";
import { connect } from "dva";
import styles from "./home.less";
import { getIntlContent } from '../../utils/IntlUtils'
import { emit } from "../../utils/emit";
@connect(({ global }) => ({
  global
}))
export default class Home extends Component {

  constructor(props) {
    super(props);
    this.state = {
      localeName: ''
    }
  }
  changeLocales(locale) {
    this.setState({
      localeName: locale
    })
  }

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: "global/fetchPlatform"
    });
    emit.on('change_language', lang => this.changeLocales(lang))
  }
  render() {
    return (
      <div className={styles.content}>
        <span>{getIntlContent("SOUL.HOME.WELCOME")}</span>
      </div>
    );
  }
}