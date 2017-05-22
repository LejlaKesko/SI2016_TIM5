import Ember from 'ember';

export default Ember.Route.extend({
  userService: Ember.inject.service(),
     model: function(params) {
        return Ember.RSVP.hash({
            user: this.get('userService').getById(params.id)
        });
    }


});