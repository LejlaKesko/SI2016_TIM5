import DS from 'ember-data';

export default DS.Model.extend({
  firstName: DS.attr("string"),
  lastName: DS.attr("string"),
  cv: DS.attr("string"),
  imageLink: DS.attr("string"),
  info: DS.attr("string"),
  link: DS.attr("string"),
});
