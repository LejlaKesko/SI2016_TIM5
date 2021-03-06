import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('info');
  this.route('organization');
  this.route('program');
  this.route('schedule');
  this.route('travel-accomodation');
  this.route('login');
  this.route('register');

  this.route('speakers', function() {
  this.route('show', { path: '/:id' });  });

  this.route('add-reviewer');
  this.route('add-speaker');
  this.route('adminpage');
  this.route('docrecenzent');
  this.route('passwordchange');
  this.route('worksubmit');
  this.route('submit-application');

  this.route('users', function() {
    this.route('show', { path: '/:id' });
    this.route('reviewers');
  });

  this.route('dokument', function() {
    this.route('show', { path: '/:id' });
    this.route('userdoc');
    this.route('userRdoc');
    this.route('docsforreview');
    this.route('reviewed');
  });
  this.route('acceptedworks');
  this.route('overviewworks');
  this.route('reviewerpage');
  this.route('userpage');
  this.route('add');
  this.route('addAdmin');
  this.route('add-admin');
  this.route('search');
  this.route('document.reviewed');
  this.route('dokument.reviewed');
});

export default Router;
